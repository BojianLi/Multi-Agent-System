param m, integer, > 0;
/* number of agents */

param n, integer, > 0;
/* number of tasks */

set I := 1..m;
/* set of agents */

set J := 1..n;
/* set of tasks */

param c{i in I, j in J}, >= 0;
/* cost of allocating task j to agent i */

var x{i in I, j in J}, >= 0;
/* x[i,j] = 1 means task j is assigned to agent i
   note that variables x[i,j] are binary, however, there is no need to
   declare them so due to the totally unimodular constraint matrix */

s.t. phi{i in I}: sum{j in J} x[i,j] = 1;
/* each agent can perform at most one task */

s.t. psi{j in J}: sum{i in I} x[i,j] = 1;
/* each task must be assigned exactly to one agent */

maximize obj: sum{i in I, j in J} c[i,j] * x[i,j];
/* the objective is to find a cheapest assignment */

solve;

printf "     Total: %10g\n", sum{i in I, j in J} c[i,j] * x[i,j];
printf "\n";



end;
