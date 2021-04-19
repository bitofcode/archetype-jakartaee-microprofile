# Build
```
mvn clean package
```

# System Test

The application (${rootArtifactId}-app) should be up and running

```
mvn compile test failsafe:integration-test -pl :${rootArtifactId}-st
```
