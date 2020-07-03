## Repository Pattern Demo

日本語は下にあります

A small Spring Boot app with a demonstration of the repository pattern. 

To run the app and the tests you will need to install mysql and create a database called `demo`.

On Mac OS, this can be done with homebrew:

`brew install mysql`
`brew services start mysql`
`mysql -uroot`

Then execute this SQL: `CREATE DATABASE demo;`

To execute the tests,

`./gradlew test`

To run the app,

`./gradlew bootRun` and go to `http://localhost:8080/`

Some notes:

- The repository pattern has nothing to do with Spring Boot. I'm just using the framework to give a better idea of what the pattern might look like in a real app.
- All implementations of the CustomerRepository interface should make the tests in CustomerRepositoryContractTests pass. The contract tests are intended to capture the desired behaviour of the repository, not the implementation details.
- Two implementations of the CustomerRepository interface have been provided. The same tests are used in both cases.
- The InMemoryCustomerRepositoryFake implementation does not persist data, so it has been put in the test package since it is not meant for production. It can be used as a fake test double, as defined [here](https://blog.cleancoder.com/uncle-bob/2020/05/27/ReplDrivenDesign.html). 
- The repository pattern can be useful when you haven't decided what persistence you want to use. The contract tests provide a contract that your future implementation should honour.
- The repository pattern helps when the persistence method needs to be changed.  

リポジトリーパターンの例です。

アプリとテストを実行するため、MySQLが必要です。`demo`というデータベースを作成してください。

Mac OSの場合、Homebrewが便利です:

`brew install mysql`
`brew services start mysql`
`mysql -uroot`

そして、`CREATE DATABASE demo;`　を実行。

テストは

`./gradlew test`

アプリは

`./gradlew bootRun` を実行し `http://localhost:8080/`　を開く

伝えたいこと：


- リポジトリーパターンはSpring Bootと関係ありません。Spring Bootのフレームワークの中ですとパターンの現実的な使い方が分かりやすくなると思っていただけです。
- CustomerRepositoryのimplementationはCustomerRepositoryContractTestsのテストを成功させるべきです。CustomerRepositoryContractTestsはCustomerRepositoryの振る舞いを表すためのものです。
- 今のところ、CustomerRepositoryのimplementationは２つあります。
- InMemoryCustomerRepositoryFakeはデータを「保存」しないので、mainで使わないはずです。[Fake Test Double](https://postd.cc/the-little-mocker/)として使えます。
- MySQLのデータベースを使うか、NoSQLのDBを使うか、Redisを使うか、保存の仕方がまだわからない場合、リポジトリーパターンは便利です。 CustomerRepositoryContractTestsは将来のimplementationの「契約」のようなものです。
- 保存の仕方を変更しなければならない場合、最初からリポジトリーパターンを使っていれば便利です。  
