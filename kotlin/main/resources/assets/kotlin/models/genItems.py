#!/usr/bin/python3
# -*- coding: utf-8 -*-

import genItem

if __name__ == "__main__":
    mod_name = "kotlin"
    items = ["kotlin", "cold_java", "java"]

    for item in items:
        genItem.genItemModel(mod_name, item)
