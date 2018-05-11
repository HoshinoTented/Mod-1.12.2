#!/usr/bin/python3
# -*- coding: utf-8 -*-

import os
import sys

mod_name = "kotlin"

print("Current mod name: " + mod_name)

if len(sys.argv) <= 1:
    item_name = input("Please input item name: ")
else:
    item_name = sys.argv[1]

content = """{
    "parent": "builtin/generated",
    "textures": {
        "layer0": "%s:items/%s"
    },
    "display": {
        "thirdperson": {
            "rotation": [ -90, 0, 0 ],
            "translation": [ 0, 1, -2 ],
            "scale": [ 0.55, 0.55, 0.55 ]
        },
        "firstperson": {
            "rotation": [ 0, -135, 25 ],
            "translation": [ 0, 4, 2 ],
            "scale": [ 1.7, 1.7, 1.7 ]
        }
    }
}
""" % (mod_name, item_name)

configuration_file = open("./item/%s.json" % item_name, "w")
configuration_file.write(content)
configuration_file.close()

print("Wrote!")
