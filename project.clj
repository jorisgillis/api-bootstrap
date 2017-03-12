(defproject api-bootstrap "0.1.0-SNAPSHOT"
  :description "Bootstrap project for creating a RESTful API with Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [integrant "0.2.2"]
                 [ring "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.2"]
                 [hikari-cp "1.7.5"]
                 [org.mariadb.jdbc/mariadb-java-client "1.5.8"]
                 [yesql "0.5.0"]]
  :profiles {:dev {:dependencies [[integrant/repl "0.1.1"]]
                   :source-paths ["dev"]
                   :main         user}}
  :main api-bootstrap.main
  :aot [api-bootstrap.main])
