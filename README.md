# api-bootstrap

A skeleton Clojure project for building a REST API. 

## Setup

Start MariaDB in a Docker container:
```
docker run -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d mariadb
```

Try to connect:
```
mysql -h 127.0.0.1 -uroot 
```

Initialize database:
```
mysql -h 127.0.0.1 -uroot < init-db.sql
```

## Usage

Development:
```
$ lein repl
user => (go) # To start
user => (reset) # To reset system
```

To run the project from the command line:
```
lein run
```

To build a jar:
```
lein uberjar
```

## License

Copyright © 2017 Joris Gillis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
