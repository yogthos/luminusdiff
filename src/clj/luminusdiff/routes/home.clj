(ns luminusdiff.routes.home
  (:require
   [luminusdiff.layout :as layout]
   [clojure.java.io :as io]
   [luminusdiff.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]])

