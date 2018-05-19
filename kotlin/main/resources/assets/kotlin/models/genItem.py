#!/usr/bin/python3
# -*- coding: utf-8 -*-

import sys
import common


def genItemModel(mod_name, item_name):
    content = """{
    "parent": "builtin/generated",
    "textures": {
        "layer0": "%s:items/%s"
    }
}
""" % (mod_name, item_name)

    configuration_file = open("./item/%s.json" % item_name, "w")
    configuration_file.write(content)
    configuration_file.close()


if __name__ == '__main__':
    mod_name = common.mod_name

    print("Current mod name: " + mod_name)

    if len(sys.argv) <= 1:
        item_name = input("Please input item name: ")
    else:
        item_name = sys.argv[1]

    genItemModel(mod_name, item_name)

    if not common.checkTextures("items", item_name):
        print("Texture not found!")

    print("Wrote!")
