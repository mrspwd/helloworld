local str = {}

function random( n, m )
    math.randomseed(os.clock()*math.random(1000000,90000000)+math.random(1000000,9000000))
    return math.random(n,m)
end

local  numArr  = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
for  i = #numArr, 1, -1 do  
    local  index =  random(1, 9);
    local  tempNum = numArr[i];
    numArr[i] = numArr[index];
    numArr[index] = tempNum;
end
for  i = 1, 9 do
    print(numArr[i])
end