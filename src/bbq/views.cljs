(ns bbq.views
  (:require
   [re-frame.core :as re-frame]
   [bbq.events :as events]
   [bbq.subs :as subs]
   ))

(defn main-panel []
  (let [result (re-frame/subscribe [::subs/result])
        first (re-frame/subscribe [::subs/first])]

    (when @first (re-frame/dispatch [::events/fetch-users]))

    [:div.container
     [:div.head "Breaking Bad"]
     [:div.result
      [:div.quote (:quote @result)]
      [:div.author (str "~ " (:author @result) " ~")]]
     [:button.btn {:on-click #(re-frame/dispatch [::events/fetch-users])} "Get a quote"]]))
