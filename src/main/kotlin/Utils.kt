import java.io.File

/**
 * Copyright (c) 2015-2020 Homonoia Studios.
 *
 * @author alexparlett
 * @since 01/12/2020
 */

fun readLines(path: String): List<String>
        = File(path).readLines()