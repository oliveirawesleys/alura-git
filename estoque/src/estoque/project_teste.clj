(ns estoque.project-teste
  (:require [cheshire.core :refer :all]))
(require '[clojure.data.json :as json])


(def account (json/read-str (slurp "C:/Users/olive/Desktop/clojureTest.json")
                            :key-fn keyword))


(def holderT (generate-string {:account {:active-card true, :available-limit 100}}))
(def purchaseT (generate-string {:transaction {:merchant "Burger King", :amount 220,
                                               :time     "2019-02-13T10:00:00.000Z"}}))


(def holder {:account {:active-card true, :available-limit 100}})
(def purchase {:transaction {:merchant "Burger King", :amount 110,
                             :time     "2019-02-13T10:00:00.000Z"}})


(def valorHolder (-> holder
                     :account
                     :available-limit))

(def valorPurchase (-> purchase
                       :transaction
                       :amount))



(defn atualiza-saldo?
  [valorHolder]
  (- valorHolder valorPurchase))



(defn tem-violacao?
  [valor-conta valor-lancamento]
  (if (> valor-conta valor-lancamento)
    (atualiza-saldo? valor-conta)
    (println (assoc holder :violations ["insufficient-limit"]))))


(defn valida-criacao-conta
  [account]
  (if (> (count account) 1)
    (println (assoc holder :violations []))
    (println (assoc holder :violations ["account-already-initialized"]))))


(defn transacao
  [purchase]
  (if (tem-violacao? valorHolder valorPurchase)
    (println (update-in holder [:account :available-limit] atualiza-saldo?))
    ;(println (assoc holder :violations []))
    ))


;(println (update-in holder [:account :available-limit] atualiza-saldo?))
(transacao holder)

(println (count account))
(valida-criacao-conta account)












