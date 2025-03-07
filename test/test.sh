#!/bin/bash

echo "Running tests..."

# Check for Maven or Gradle files
if [ -f "pom.xml" ]; then
  echo "Maven project detected, running Maven tests..."
  mvn test
elif [ -f "build.gradle" ]; then
  echo "Gradle project detected, running Gradle tests..."
  ./gradlew test
else
  echo "No supported build file (pom.xml or build.gradle) found."
  exit 1
fi

echo "Tests completed."
