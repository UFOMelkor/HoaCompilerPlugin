%token true true
%token false false

boolean:
    <true> | <false>

booleans:
    boolean() (boolean()+ #)?
