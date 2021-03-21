FROM alpine:3.10.3

WORKDIR /protoc

RUN apk add --no-cache unzip curl
RUN PB_REL="https://github.com/protocolbuffers/protobuf/releases" \
  && curl -LO $PB_REL/download/v3.14.0/protoc-3.14.0-linux-x86_64.zip \
  && unzip protoc-3.14.0-linux-x86_64.zip

FROM ghcr.io/graalvm/graalvm-ce:21.0.0

COPY ./build/libs/native-image.jar .
COPY --from=0 /protoc ./protoc

RUN export PATH="$PATH:/protoc/bin" \
  && gu install native-image \
  && native-image --verbose -jar native-image.jar

EXPOSE 9000

CMD ["./native-image"]
