(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenicated]]))

(defn nav
  []
  (let [user true]
    (if user
      [authenicated]
      "public")))
