#!/usr/bin/python3
# -*- coding: utf-8 -*-
# 大概只是一些全局的变量, 不想一个一个去改之类的

import os

mod_name = "kotlin"


def checkTextures(type, name):
    return os.path.isfile("../textures/%s/%s.png" % (type, name))
