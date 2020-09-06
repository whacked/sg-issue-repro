(defproject tester "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 ;; [org.clojure/clojurescript "1.10.520"]
                 [org.clojure/clojurescript "1.10.773"]
                 [prismatic/schema "1.1.12"]
                 [prismatic/schema-generators "0.1.3"]]
  :plugins [[lein-cljsbuild "1.1.8"]]

  :cljsbuild {:builds {:app
                       {:source-paths ["src"]
                        :compiler {:main mytest.core
                                   :target :nodejs
                                   :output-to "out/index.js"}}}})

