#!/bin/sh

# Define the project directories (matching your module names)
projects="apigateway joke quote microauthentication"
parallel=false

# Check for -p flag to enable parallel builds
if [ "$1" = "-p" ]; then
  parallel=true
fi

# Loop through each module and build a Docker image using Spring Boot Buildpacks
for project in $projects; do
  echo "🔨 Building image for $project..."

  if [ "$parallel" = true ]; then
    (cd "$project" && ./mvnw -q --no-transfer-progress spring-boot:build-image) &
  else
    (cd "$project" && ./mvnw spring-boot:build-image)
  fi
done

# Wait for parallel jobs to complete
if [ "$parallel" = true ]; then
  wait
fi

# Start Docker Compose
echo "🚀 Starting up Docker Compose..."
docker-compose up -d
