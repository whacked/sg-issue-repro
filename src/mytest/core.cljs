(ns mytest.core
  (:require
   [schema.core :as s :include-macros true]
   [schema-generators.generators :as g]
   [clojure.test.check.generators :as gen]
   [clojure.test.check.random :as random]
   [clojure.test.check.impl :refer [get-current-time-millis]]))


(defn -main []
  (println "============== ============== large integer\n")
  (println
   (gen/sample gen/large-integer))

  (println "============== ============== string\n")
  (println
   (gen/sample gen/string))

  (println "============== ============== random\n")
  (let [rng (random/make-random (get-current-time-millis))]
    (dotimes [n 10]
      (println "-->" (random/rand-long rng))))

  (println "============== ============== compound\n")
  (println
   (g/generate {:a s/Int})))

(-main)
