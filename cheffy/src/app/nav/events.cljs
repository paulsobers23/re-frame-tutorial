(ns app.nav.events
  (:require [re-frame.core :refer [reg-event-db]]))

;; the first one is the name of the event
;; second value is the value we passed from the client

(reg-event-db
 :set-active-nav ;;(rf/dispatch [:set-active-nae :recipes or :saved etc])
 (fn [db [_ active-nav]]
   (assoc-in db [:nav :active-nav] active-nav)))
