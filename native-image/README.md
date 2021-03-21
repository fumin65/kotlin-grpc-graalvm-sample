# Kotlin gPRC on GraalVM サンプル

## 概要

kotlin+gRPC+GraalVMの最小構成のサンプル。

| 使用技術 | バージョン |
| --- | --- |
| Kotlin | 1.4.30 |
| GraalVM | 21.0.0 |
| gRPC | 1.36.0 |

## ネイティブイメージのビルド

```
./gradlew native-image:buildNativeImage
```
