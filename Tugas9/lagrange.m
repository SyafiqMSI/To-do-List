#Muhammad Syafiq Ibrahim (L0122116)

function itp=lagrange(xy)
  x=xy(:,1);
  y=xy(:,2);
  itp="";
  for i=1:length(x) %Menghitung elemen summation
    L="";
    for j=1:length(x) %Menghitung produk Li
      if j==i continue endif
      L=strcat(L,"(x-",num2str(x(j)),")./(",num2str(x(i)-x(j)),").*");
    endfor
    L=strcat(L,num2str(y(i)));
    itp=strcat(itp,"+",L);
  endfor
  itp=str2func(strcat("@(x)",itp(2:length(itp))));
end

