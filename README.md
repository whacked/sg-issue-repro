# (temp) repro issue using shadow-cljs-browser-quickstart base

## repro steps

### terminal 1

```sh
npm install
export PATH=$PATH:$(npm bin)
shadow-cljs --cli-info
# > === Version
# > jar:            2.8.71
# > cli:            2.8.71
# > deps:           1.3.1
# > config-version: 2.8.71
# > ...
shadow-cljs watch app
# > ...
# > shadow-cljs - HTTP server available at http://localhost:8020
# > shadow-cljs - server version: 2.8.71 running at http://localhost:9631
# > shadow-cljs - nREPL server started on port 38745
# > ...
# > [:app] Configuring build.
# > [:app] Compiling ...
# > [:app] Build completed. (135 files, 134 compiled, 0 warnings, 10.81s)
```

### browser

open browser to http://localhost:8020 as indicated above, which displays "shadow-cljs - Browser"

### terminal 2

working example (shadow-cljs 2.8.71 / clojurescript 1.10.520)

```
$ shadow-cljs cljs-repl app
cljs.user=> (require '[schema.core :as s :include-macros true])
nil
cljs.user=> (require '[schema-generators.generators :as g])
nil
cljs.user=> (g/generate s/Int)
-397
cljs.user=> (g/generate {:id s/Int})
{:id -20}
cljs.user=>
```

non-working example (shadow-cljs 2.11.1 / clojurescript 1.10.773)

```
$ shadow-cljs cljs-repl app
cljs.user=> (require '[schema.core :as s :include-macros true])
nil
cljs.user=> (require '[schema-generators.generators :as g])
nil
> (g/generate s/Int)
-509
cljs.user=> (g/generate {:id s/Int})
#error {:message "Couldn't satisfy such-that predicate after 10 tries.", :data {:pred #object[G__31581], :gen #clojure.test.check.generators.Generator{:gen #object[Function]}, :max-tries 10}}
```

