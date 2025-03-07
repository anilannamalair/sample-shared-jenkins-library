#!/bin/bash

echo "Starting the build process..."

# Check for Maven or Gradle files
if [ -f "pom.xml" ]; then
  echo "Maven project detected, running Maven build..."
  mvn clean install -DskipTests
elif [ -f "build.gradle" ]; then
  echo "Gradle project detected, running Gradle build..."
  ./gradlew build -x test
else
  echo "No supported build file (pom.xml or build.gradle) found."
  exit 1
fi

echo "Build completed."
