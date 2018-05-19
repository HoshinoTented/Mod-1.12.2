#!/usr/bin/python3
# -*- coding: utf-8 -*-

import sys

mod_name = "kotlin"

print("Current mod name: " + mod_name)

if len(sys.argv) <= 1:
    block_name = input("Please input block name: ")
else:
    block_name = sys.argv[1]

parent = """{
    "parent": "block/cube_all",
    "textures": {
        "all": "%s:blocks/%s"
    }
}
""" % (mod_name, block_name)

item = """{
    "parent": "%s:block/%s",
    "display": {
        "thirdperson": {
            "rotation": [ 10, -45, 170 ],
            "translation": [ 0, 1.5, -2.75 ],
            "scale": [ 0.375, 0.375, 0.375 ]
        }
    }
}
""" % (mod_name, block_name)

block_states = """{
    "variants": {
        "normal": { "model": "%s:%s" }
    }
}
""" % (mod_name, block_name)

parent_file = open("./block/%s.json" % block_name, "w")
item_file = open("./item/%s.json" % block_name, "w")
block_states_file = open("../blockstates/%s.json" % block_name, "w")

parent_file.write(parent)
item_file.write(item)
block_states_file.write(block_states)

parent_file.close()
item_file.close()
block_states_file.close()

print("Wrote!")
