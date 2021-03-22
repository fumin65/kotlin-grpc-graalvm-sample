# Clean Architecture サンプル

## 概要

このサンプルは、gradleのモジュールを使用して物理的にレイヤー間に依存性の方向を強制するサンプルです。

## モジュール間の依存

各モジュールはレイヤー毎に定義されており、以下のような依存関係になっています。

```
main -> layer-infrastructure -> layer-presentation -> layer-application -> layer-domain
```

これにより、より右側のモジュールのコードセットから、より左側のモジュールのコードセットは参照できなくなり、依存の方向を壊すような参照を行うことができなくなります。

## ビルド&実行

プロジェクトのルートから以下のコマンドを実行

```
./gradlew clean-archit:main:build
```

作成されたjarを実行

```
java -jar clean-archit/main/build/libs/clean-archit-app.jar
```
