(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenicated]]
             [app.nav.views.public :refer [public]]))

(defn nav
  []
  (let [user false]
    (if user
      [authenicated]
      [public])))
