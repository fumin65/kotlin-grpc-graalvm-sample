FROM alpine:3.10.3

WORKDIR /protoc

RUN apk add --no-cache unzip curl
RUN PB_REL="https://github.com/protocolbuffers/protobuf/releases" \
  && curl -LO $PB_REL/download/v3.14.0/protoc-3.14.0-linux-x86_64.zip \
  && unzip protoc-3.14.0-linux-x86_64.zip

FROM ghcr.io/graalvm/graalvm-ce:21.0.0 as build

COPY . .
COPY --from=0 /protoc ./protoc

RUN export PATH="$PATH:/protoc/bin" \
  && gu install native-image \
  && ./gradlew native-image:build \
  && native-image --verbose --no-fallback \
    -H:ReflectionConfigurationFiles=native-image/config.json \
    --allow-incomplete-classpath \
    -jar native-image/build/libs/grpc-app.jar

FROM debian:buster-slim

COPY --from=build /grpc-app .

CMD ["./grpc-app"]
