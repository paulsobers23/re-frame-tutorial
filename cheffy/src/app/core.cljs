
(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            ;;-- auth --
            [app.auth.views.profile :refer [profile]]
            [app.auth.views.sign-up :refer [sign-up]]
            [app.auth.views.login :refer [login]]

            ;; -- become-a-chef --
            [app.become-a-chef.views.become-a-chef :refer [become-a-chef]]
            ;; -- inbox --
            [app.inbox
             .views.inboxes :refer [inboxes]]
            ;; -- nav --
            [app.nav.views.nav :refer [nav]]
            [app.nav.events]
            [app.nav.subs]
            ;; -- nav --
            ;;-- recipes --
            [app.recipes.views.recipes :refer [recipes]]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize Button ThemeProvider Grid Row Col]]))

(defn pages
  [page-name]
  (case page-name
    :profile [profile]
    :become-a-chef [become-a-chef]
    :inboxes [inboxes]
    :recipes [recipes]
    :sign-up [sign-up]
    :login [login]
    [recipes])) ;;default value

(defn app
  []
  (let [active-nav @(rf/subscribe [:active-nav])]
    [:<>
     [(r/adapt-react-class Normalize)]
     [:> ThemeProvider {:theme cheffy-theme}
      [:> Grid {:fluid false}
       [:> Row
        [:> Col
         [nav]
         [pages active-nav]]]]]
   ])
  )


(defn ^:dev/after-load start ;;comes from shadowcljs
  []
  (rf/dispatch-sync [:init-db]) ;; all events from re-frame is async unless we use sync
  (r/render [app]
    (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))
