'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // BASE_API: '"http://148.70.97.159:8081"'
  BASE_API: '"http://localhost:8081"'
})
