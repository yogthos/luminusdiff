(defproject luminusdiff "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[ch.qos.logback/logback-classic "1.2.3"]
                 [cheshire "5.10.0"]
                 [clojure.java-time "0.3.2"]
                 [com.google.protobuf/protobuf-java "3.8.0"]
                 [conman "0.8.7"]
                 [cprop "0.1.16"]
                 [expound "0.8.4"]
                 [funcool/struct "1.4.0"]
                 [luminus-jetty "0.1.9"]
                 [luminus-migrations "0.6.7"]
                 [luminus-transit "0.1.2"]
                 [luminus/ring-ttl-session "0.3.3"]
                 [markdown-clj "1.10.4"]
                 [metosin/muuntaja "0.6.6"]
                 [metosin/reitit "0.4.2"]
                 [metosin/ring-http-response "0.9.1"]
                 [mount "0.1.16"]
                 [mysql/mysql-connector-java "8.0.18"]
                 [nrepl "0.7.0"]
                 [org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.cli "1.0.194"]
                 [org.clojure/tools.logging "1.0.0"]
                 [org.webjars.npm/bulma "0.8.1"]
                 [org.webjars.npm/material-icons "0.3.1"]
                 [org.webjars/webjars-locator "0.39"]
                 [ring-webjars "0.2.0"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-defaults "0.3.2"]
                 [selmer "1.12.22"]]

  :min-lein-version "2.0.0"
  
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :resource-paths ["resources"]
  :target-path "target/%s/"
  :main ^:skip-aot luminusdiff.core

  :plugins [] 

  :profiles
  {:uberjar {:omit-source true
             :aot :all
             :uberjar-name "luminusdiff.jar"
             :source-paths ["env/prod/clj" ]
             :resource-paths ["env/prod/resources"]}

   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]

   :project/dev  {:jvm-opts ["-Dconf=dev-config.edn" ]
                  :dependencies [[pjstadig/humane-test-output "0.10.0"]
                                 [prone "2020-01-17"]
                                 [ring/ring-devel "1.8.0"]
                                 [ring/ring-mock "0.4.0"]]
                  :plugins      [[com.jakemccrary/lein-test-refresh "0.24.1"]
                                 [jonase/eastwood "0.3.5"]] 
                  
                  :source-paths ["env/dev/clj" ]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns user
                                 :timeout 120000}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]}
   :project/test {:jvm-opts ["-Dconf=test-config.edn" ]
                  :resource-paths ["env/test/resources"] }
   :profiles/dev {}
   :profiles/test {}})
