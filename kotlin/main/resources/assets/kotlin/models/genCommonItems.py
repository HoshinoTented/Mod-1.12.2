#!/usr/bin/python3
# -*- coding: utf-8 -*-

import genItem
import common


if __name__ == "__main__":
    mod_name = common.mod_name
    items = ["kotlin", "cold_java", "java", "scala_piece", "scala", "final_pickaxe"]

    for item in items:
        genItem.genItemModel(mod_name, item)

        if not common.checkTextures("items", item):
            print("Texture of %s not found" % item)
