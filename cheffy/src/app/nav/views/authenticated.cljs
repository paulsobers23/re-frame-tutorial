(ns app.nav.views.authenticated
  (:require [re-frame.core :as rf]
            [app.nav.views.nav-item :refer [nav-item]]
            ["@smooth-ui/core-sc" :refer [Box]]))
;;subscriptons
(defn authenicated
  []
  (let [active-nav @(rf/subscribe [:active-nav]) ;; reagent atom behing scene?
        nav-items [{:id :saved  ;; all of our maps are extened by dispatch
                   :name "Saved"
                    :href "#saved"
                    :dispatch #(rf/dispatch [:set-active-nav :saved])}
                  {:id :recipes
                   :name "Recipes"
                   :href "#recipes"
                   :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                  {:id :become-a-chef
                   :name "Chef Paulyy"
                   :href "#become-a-chef"
                   :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                  {:id :profile
                   :name "Profile"
                   :href "#profile"
                   :dispatch #(rf/dispatch [:set-active-nav :profile])}
                  {:id :inboxes
                   :name "Inbox"
                   :href "#inbox"
                   :dispatch #(rf/dispatch [:set-active-nav :inboxes])}
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

