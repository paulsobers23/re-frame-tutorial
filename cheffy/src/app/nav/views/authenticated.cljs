(ns app.nav.views.authenticated
  (:require [reagent.core :as r] ["@smooth-ui/core-sc" :refer [Box]]))

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
     (for [{:keys [id name href]} nav-items] ;; list comprehension && destructing
       [(r/adapt-react-class Box) {:key id
                                   :as "a"
                                   :href href
                                   :ml 2
                                   :pb 10}
        name])]))
