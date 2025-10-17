(defproject doplarr "3.6.3"
  :description "An arr request bot for Discord"
  :url "https://github.com/BURGEJOS000/Doplarr"
  :license {:name "MIT"}
  :main doplarr.core
  :source-paths ["src"]
  :resource-paths ["resources"]
  :jvm-opts ["-Dconfig=config.edn"]
  :repositories [["my-repo" {:url "https://github.com/kiranshila/discljord"
                             :cred :gpg}]]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [io.aviso/pretty "1.1.1"]
                 [org.clojure/core.cache "1.0.225"]
                 [yogthos/config "1.2.0"]
                 [com.rpl/specter "1.1.4"]
                 [expound/expound "0.9.0"]
                 [org.clojure/core.async "1.5.648"]
                 [cheshire/cheshire "5.11.0"]
                 [fmnoise/flow "4.2.1"]
                 [hato/hato "0.8.2"]
                 [com.taoensso/timbre "5.2.1"]
                 [camel-snake-kebab/camel-snake-kebab "0.4.3"]])
