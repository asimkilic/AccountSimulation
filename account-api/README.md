The assesment consist of an API to be used for opening a new "current account" of already existing customers.

#### Requirements

* The API will expose an endpoint which accepts the user information(CustomerID, initialCredit).
* Once the endpoint is called, a new account will be opened connected to the user whose ID is customerId.
* Also, if initialCredit is not 0, transaction will be sent to the new account.
* Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts

#### Bonuses

* Accounts and Transactions are different services.
* Frontend (simple one is OK)
* Attention to CI/CD

#### Contstaints 

Feel free to use any open source tool or framework.

For storing the information, the data can be saved in memory and not actually persisted to an external database, so that we can test the solution easier. However, remember this is a backend assignment and consider layers, abstractions testability, and enterprise-level architecture carefully.

The programming language by default is Java / C# but we are flexible if you let us know which other language prefer.

#### Expectations 

The expected deliverable is the source code published on Github or Gitlab and instructions on how to execute and test it.

We hope to see demonstration of good git practice and workflow; show us how you work in a team. Testability will be also assessed.



```xml
<properties>
    <java.version>11</java.version>
    <kotlin.version>1.6.0</kotlin.version>
</properties>
<dependency>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-stdlib-jdk8</artifactId>
    <version>${kotlin.version}</version>
</dependency>
<dependency>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-reflect</artifactId>
    <version>${kotlin.version}</version>
</dependency>
<dependency>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-runtime</artifactId>
    <version>1.2.71</version>
</dependency>
	<plugin>
				<artifactId>kotlin-maven-plugin</artifactId>
				<groupId>org.jetbrains.kotlin</groupId>
				<version>${kotlin.version}</version>
				<configuration>
					<compilerPlugins>
						<plugin>jpa</plugin>
					</compilerPlugins>
				</configuration>
				<dependencies>
					<dependency>
						<groupId>org.jetbrains.kotlin</groupId>
						<artifactId>kotlin-maven-noarg</artifactId>
						<version>${kotlin.version}</version>
					</dependency>
				</dependencies>
				<executions>
					<execution>
						<id>compile</id>
						<goals>
							<goal>compile</goal>
						</goals>
						<configuration>
							<sourceDirs>
								<sourceDir>${project.basedir}/src/main/kotlin</sourceDir>
								<sourceDir>${project.basedir}/src/main/java</sourceDir>
							</sourceDirs>
							<args>
								<arg>-Xskip-prerelease-check</arg>
							</args>
						</configuration>
					</execution>
					<execution>
						<id>test-compile</id>
						<goals>
							<goal>test-compile</goal>
						</goals>
						<configuration>
							<sourceDirs>
								<sourceDir>${project.basedir}/src/test/kotlin</sourceDir>
								<sourceDir>${project.basedir}/src/test/java</sourceDir>
							</sourceDirs>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>
				<executions>
					<execution>
						<id>default-compile</id>
						<phase>none</phase>
					</execution>
					<execution>
						<id>default-testCompile</id>
						<phase>none</phase>
					</execution>
					<execution>
						<id>java-compile</id>
						<phase>compile</phase>
						<goals>
							<goal>compile</goal>
						</goals>
					</execution>
					<execution>
						<id>java-test-compile</id>
						<phase>test-compile</phase>
						<goals>
							<goal>testCompile</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```



```powershell
docker build . -t account:1.0

docker run --name account -d -p 9090:8080 account:1.0

docker system prune
docker container rm -f < imageid >
```

