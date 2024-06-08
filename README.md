# Kotlin,Spring3でREST API作成

https://medium.com/@dpeachesdev/exploring-springboot3-with-kotlin-by-building-an-ecommerce-server-part-1-7c18e3241a97

ORMはJPAを使用。
レポジトリでアノテーションをつけるだけで基本的なCRUD行うメソッドを追加できるのが良かった。
IDの生成方法で少しハマった。

```kotlin
package com.example.springboot_3kotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Greeting(
    @Id
+    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOMATIC生成戦略を指定
    val id: Long? = null,
    val languageKey: String,
    val greeting: String
)
```

curl の結果
```commandline
curl -X POST -H "Content-Type: application/json" -d '{"languageKey":"en", "greeting":"Hello World!"}' http://localhost:8080/greeting
{"id":1,"languageKey":"en","greeting":"Hello World!"}%                                                                                                                                                                                    
curl -X POST -H "Content-Type: application/json" -d '{"languageKey":"jp", "greeting":"こんにちは"}' http://localhost:8080/greeting
{"id":2,"languageKey":"jp","greeting":"こんにちは"}%                                                                                                                                                                                      
curl -X GET -H "Content-Type: application/json" http://localhost:8080/greeting/2
{"id":2,"languageKey":"jp","greeting":"こんにちは"}%                                                                                                                                                                                      
curl -X GET -H "Content-Type: application/json" http://localhost:8080/greeting/1
{"id":1,"languageKey":"en","greeting":"Hello World!"}%                                                                                                                                                                                    
```