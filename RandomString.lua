-- 生成随机字符串
function random( n, m )
    math.randomseed(os.clock()*math.random(1000000,90000000)+math.random(1000000,9000000))
    return math.random(n,m)
end

-- 随机数字
function randomNumber( len )
    local rt = ""
    for i=1,len do
        if i == 1 then
            rt = rt..random(1,9)
        else
            rt = rt..random(0,9)
        end
    end
    return rt
end

-- 随机小写字母
function randomLetter( len )
    local rt = ""
    for i=1,len do
        rt = rt..string.char(random(97,122))
    end
    return rt
end

-- 随机大写字母
function randomCapital( len )
    local rt = ""
    for i=1,len do
        rt = rt..string.char(random(65,90))
    end
    return rt
end

-- 字符串随机枚举表 
local x = 1
RDModle = {}
RDModle.RSM_Capital = x; x = x + 1 -- 纯大写字母
RDModle.RSM_Letter  = x; x = x + 1 -- 纯小写字母
RDModle.RSM_Cap_Let = x; x = x + 1 -- 大小写字母
RDModle.RSM_Number  = x; x = x + 1 -- 纯数字
RDModle.RSM_Cap_Num = x; x = x + 1 -- 大写字母和数字
RDModle.RSM_Let_Num = x; x = x + 1 -- 小写字母和数字
RDModle.RSM_All     = x; x = x + 1 -- 全部类型(数字+大小写字母)

-- 指定长度的随机文本
function RandomString( len, modl )
    local BC = "ABCDEFGHIJKLMNOPQRSDUVWXYZ"
    local SC = "abcdefghijklmnopqrsduvwxyz"
    local NO = "0123456789"
    local maxLen = 0
    local templete = ""
    if modl == RDModle.RSM_Capital then
        templete = BC
        maxLen = 26
    elseif modl == RDModle.RSM_Letter then
        templete = SC
        maxLen = 26
    elseif modl == RDModle.RSM_Cap_Let then
        templete = SC..BC
        maxLen = 52
    elseif modl == RDModle.RSM_Number then
        templete = NO
        maxLen = 10
    elseif modl == RDModle.RSM_Cap_Num then
        templete = NO..BC
        maxLen = 36
    elseif modl == RDModle.RSM_Let_Num then
        templete = NO..SC
        maxLen = 36
    elseif modl == RDModle.RSM_All then
        templete = NO..SC..BC
        maxLen = 62
    else
        templete = NO..SC..BC
        maxLen = 62
    end
    local str = {}
    for i=1,len do
        local index = random(1,maxLen)
        str[i] = string.sub(templete,index,index)
    end
    return table.concat(str,"")
end

-- test
for i=1,7 do
    print(RandomString(32,RDModle.RSM_All))
end