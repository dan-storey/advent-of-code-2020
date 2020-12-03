package net.dstack.aoc.day3

class Day3 {
    fun countTrees(map: Array<CharArray>, slope: Pair<Int, Int>): Int {
        var right = 0; var down = 0; var trees = 0
        while( down < map.size ) {
            if ( map[down][right % map[0].size] == '#' ) {
                trees++
            }
            right += slope.first
            down += slope.second
        }
        return trees
    }

}