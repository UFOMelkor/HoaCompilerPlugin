%token  quote_         "        -> string
%token  string:string  [^"]+
%token  string:_quote  "        -> default
