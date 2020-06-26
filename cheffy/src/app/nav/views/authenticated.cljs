(ns app.nav.views.authenticated
  (:require [app.nav.views.nav-item :refer [nav-item]] ["@smooth-ui/core-sc" :refer [Box]]))

(defn authenicated
  []
  (let [nav-items [{:id :saved
                   :name "Saved"
                   :href "#saved"}
                  {:id :recipes
                   :name "Recipes"
                   :href "#reciped"}
                  {:id :become-a-chef
                   :name "Chef Paulyy"
                   :href "#become-a-chef"}
                  {:id :profile
                   :name "Profile"
                   :href "#profile"}
                  {:id :inox
                   :name "Inbox"
                   :href "#inbox"}
                  ]]
    [:> Box {:display "flex"
             :justify-content "flex-end"
             :py 1}
     (for [item nav-items] ;; list comprehension && destructing
        [nav-item item])])) 
