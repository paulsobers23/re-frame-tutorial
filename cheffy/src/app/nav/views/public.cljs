(ns app.nav.views.public
  (:require [re-frame.core :as rf]
            [app.nav.views.nav-item :refer [nav-item]]
            ["@smooth-ui/core-sc" :refer [Box]]))
;;subscriptons

(defn public
  []
  (let [active-nav @(rf/subscribe [:active-nav]) ;; reagent atom behing scene?
        nav-items [{:id :recipes
                   :name "Recipes"
                   :href "#recipes"
                   :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                  {:id :become-a-chef
                   :name "Chef Paulyy"
                   :href "#become-a-chef"
                   :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                   {:id :signup
                    :name "Signup"
                    :href "#sign-up"
                    :dispatch #(rf/dispatch [:set-active-nav :sign-up])}
                  {:id :login
                   :name "Login"
                   :href "#login"
                   :dispatch #(rf/dispatch [:set-active-nav :login])}
                  ]]
    [:> Box {:display "flex"
             :justify-content "flex-start"
             :py 1}
     (for [{:keys [id name href dispatch]} nav-items] ;; list comprehension && destructing
       [nav-item {:key id
                  :id id
                  :name name
                  :href href
                  :dispatch dispatch
                  :active-nav active-nav}])]))

