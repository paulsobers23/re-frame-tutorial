
(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            [app.nav.views.nav :refer [nav]]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize Button ThemeProvider]]))

(defn app
  []
  [:<>
   [(r/adapt-react-class Normalize)]
   [:> ThemeProvider {:theme cheffy-theme}
    [ nav]]
   ]
  )


(defn ^:dev/after-load start ;;comes from shadowcljs
  []
  (rf/dispatch-sync [:init-db]) ;; all events from re-frame is async unlwss we use sync
  (r/render [app]
    (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))
