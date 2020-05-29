char * convert(char * s, int numRows)
{
    int len=strlen(s);
    int tab=2*numRows-2;
    if(len<=numRows ||tab==0)
    return s;
    char* res=(char *)malloc(sizeof(char *)*(len+1));
    int num=0;
    for(int i=0;i<=tab/2;i++)
    {
        for(int j=0;j<len;j++)
        {
            if((j+tab)%tab==i || (j+tab)%tab==(tab-i))
            {
                res[num++]=s[j];
            }
        }
    }
    res[num]='\0';
    return res;
}
