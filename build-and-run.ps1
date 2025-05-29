param (
    [switch]$p  # Use -p to run in parallel
)

# Define project directories
$projects = @("authservice", "gateway", "resourceserver")

if ($p) {
    Write-Host "🔁 Running in parallel..."

    $jobs = @()

    foreach ($project in $projects) {
        $jobs += Start-Job -ScriptBlock {
            param($proj)
            Write-Host "🔨 Building image for $proj..."
            Push-Location $proj
            ./mvnw -q --no-transfer-progress spring-boot:build-image
            Pop-Location
        } -ArgumentList $project
    }

    # Wait for all jobs to finish
    $jobs | ForEach-Object { $_ | Wait-Job; Receive-Job $_; Remove-Job $_ }
} else {
    Write-Host "🔁 Running in sequence..."

    foreach ($project in $projects) {
        Write-Host "🔨 Building image for $project..."
        Push-Location $project
        ./mvnw spring-boot:build-image
        Pop-Location
    }
}

# Start Docker Compose
Write-Host "🚀 Starting up Docker Compose..."
docker-compose up -d
