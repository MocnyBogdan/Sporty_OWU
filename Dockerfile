FROM clojure
COPY . /usr/src/learning_progr
WORKDIR /usr/src/learning_progr
CMD ["lein", "run"]