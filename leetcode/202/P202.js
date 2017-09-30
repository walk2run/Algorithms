/**
 * @param {number} n
 * @return {boolean}
 */
function isHappy(n) {
    var i, st, sum, map;
    map = {};
    while (map[n] === undefined) {
        st = String(n);
        sum = 0;
        for (i in st)
            sum += Number(st[i]) * Number(st[i]);
        if (sum == 1)
            return true;
        map[n] = sum;
        n = sum;
    }
    return false;
}
