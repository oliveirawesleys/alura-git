(ns estoque.testes)
  ;(use 'clojure.java.io)
  ;(in-ns 'clojure.data.json)
  ;(:use clojure.pprint)


;{"account": {"active-card": true, "available-limit": 100}}








(defn adiciona-lancamento
  "Os lançamentos serão carregados."
  [lancamentos conta]
  (let [account (:id conta)]
               (assoc lancamentos (:id conta) conta)))

(defn testar []
  (let [lancamentos {}
                   compra {:id 10 :active true :available 100}]
    (pprint (adiciona-lancamento lancamentos compra))))

(testar)





;(slurp "C:/Users/olive/Desktop/operations.json")




;(with-open [rdr (reader "C:/Users/olive/Desktop/operations.json")]
;  (doseq [line (line-seq rdr)]
;   (println line)))

