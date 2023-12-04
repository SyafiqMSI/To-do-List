#Muhammad Syafiq Ibrahim (L0122116)

function itp=ndd(xy)
  x=xy(:,1);
  y=xy(:,2);
  for i=2:length(x) %Membuat tabel untuk NDD
    for j=i:length(x)
      y(j,i)=(y(j,i-1)-y(j-1,i-1))/(x(j)-x(j-(i-1)));
    endfor
  endfor
  itp=num2str(y(1,1));
  temp="";
  for i=1:length(x)-1 %Merumuskan persamaan hasil interpolasi
    temp=strcat(temp,".*(x-",num2str(x(i)),")");
    itp=strcat(itp,"+",num2str(y(i+1,i+1)),temp);
  endfor
  itp=str2func(strcat("@(x)",itp));
end

