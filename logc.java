public class logc{
public boolean check(String a,String p)
{
int aa= Integer.parseInt(a);	
int pp = Integer.parseInt(p);	
if((aa==12345 && pp==123) || (aa==56789 && pp==567))
{
return true;
}
else return false;
}
}
