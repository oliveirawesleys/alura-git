(ns estoque.aula5)


(def estoque {"Mochila" 10 "Camiseta" 5})
(println estoque)

(def estoque {"Mochila"  10,
              "Camiseta" 5})
(println estoque)


(println "Temos" (count estoque) "elementos")
(println "Chaves são:" (keys estoque))
(println "Valores são:" (vals estoque))

(def estoque {:mochila  10
              :camiseta 5})

(println (assoc estoque :cadeira 3))
(println (assoc estoque :mochila 2))

(println estoque)
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "Tirando um de" valor)
  (- valor 1))

(println estoque)
(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

(println estoque)
(println (dissoc estoque :mochila))




(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println pedido)
(println "\n\n\n\n\n")

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira {}))

(println (:mochila pedido))

(println (:quantidade (:mochila pedido)))

;THREADING
(println (update-in pedido [:mochila :quantidade] inc))
(println pedido)
(println (-> pedido
             :mochila
             :quantidade))

(-> pedido
    :mochila
    :quantidade
    println)

(def clientes {
               :15 {
                    :nome         "Guilherme"
                    :certificados ["Clojure" "Java" "Machine Learning"]}})
(println clientes)
(-> clientes
    :15
    :certificados
    count)